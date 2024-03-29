package service

import android.content.Intent
import com.liberty.emv.liberty_emv.DeviceState
import com.libertyPay.horizonSDK.common.ActivityRequestAndResultCodes
import com.libertyPay.horizonSDK.common.TransactionIntentExtras
import com.libertyPay.horizonSDK.domain.models.PosTransactionException
import com.libertypay.posclient.api.models.response.TransactionData
import io.flutter.plugins.Pigeon
import service.dto.PigeonResponseDto

class ActivityResultHandler(
    private val resultCallback: Pigeon.Result<Pigeon.TransactionDataResponse>?
) {

    private val functionMap =
        mapOf<Int, (data: Intent?, resultCode: Int, requestCode: Int) -> Boolean>(
            ActivityRequestAndResultCodes.TRANSACTION_SUCCESS_RESULT_CODE to ::handleSuccessResponse,
            ActivityRequestAndResultCodes.TRANSACTION_FAILURE_RESULT_CODE to ::handleTransactionFailure,
            ActivityRequestAndResultCodes.KEY_EXCHANGE_FAILED_RESULT_CODE to ::handleKeyExchangeFailure,
            0 to ::handleCancelledTransaction,
        )


    private fun handleSuccessResponse(data: Intent?, resultCode: Int, requestCode: Int): Boolean {
        when (requestCode) {
            ActivityRequestAndResultCodes.PURCHASE_REQUEST_CODE -> {
                val balanceEnquiryData =
                    data?.getParcelableExtra<TransactionData?>(TransactionIntentExtras.TRANSACTION_RESULT)

                balanceEnquiryData?.let {
                    val emvResponse = PigeonResponseDto.toTransactionData(it)
                    emvResponse.deviceState = DeviceState.TRANS_DONE.value
                    resultCallback?.success(emvResponse)
                }
            }
            else -> {
                val balanceEnquiryData =
                    data?.getParcelableExtra<TransactionData?>(TransactionIntentExtras.TRANSACTION_RESULT)

                balanceEnquiryData?.let {
                    val emvResponse = PigeonResponseDto.toTransactionData(it)
                    emvResponse.deviceState = DeviceState.TRANS_DONE.value
                    resultCallback?.success(emvResponse)
                }

            }
        }
        return true
    }


    private fun handleTransactionFailure(
        data: Intent?,
        resultCode: Int,
        requestCode: Int
    ): Boolean {
        val posTransactionResponse =
            data?.getParcelableExtra<PosTransactionException>(TransactionIntentExtras.TRANSACTION_FAILURE)

        posTransactionResponse?.let {
            resultCallback?.error(Exception(it.errorMessage))
        }
        return true
    }

    private fun handleKeyExchangeFailure(
        data: Intent?,
        resultCode: Int,
        requestCode: Int
    ): Boolean {
        val keyExchangeException =
            data?.getParcelableExtra<PosTransactionException>(TransactionIntentExtras.KEY_EXCHANGE_FAILURE)

        keyExchangeException?.let {
            resultCallback?.error(Exception(it.errorMessage))
        }
        return true
    }

    private fun handleCancelledTransaction(
        data: Intent?,
        resultCode: Int,
        requestCode: Int
    ): Boolean {
        val response = Pigeon.TransactionDataResponse().apply {
            deviceState = DeviceState.TRANS_CANCELLED.value
        }
        resultCallback?.success(response)
        return true
    }

    operator fun invoke(data: Intent?, resultCode: Int, requestCode: Int): Boolean {
        val handlerFunction = functionMap[resultCode]
        return handlerFunction?.invoke(data, resultCode, requestCode) ?: false
    }

}