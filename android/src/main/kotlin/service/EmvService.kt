package service

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import com.liberty.emv.liberty_emv.Constants
import com.liberty.emv.liberty_emv.DeviceState
import com.libertyPay.horizonSDK.LibertyHorizonSDK
import com.libertyPay.horizonSDK.common.ActivityRequestAndResultCodes
import com.libertyPay.horizonSDK.domain.models.AccountType
import com.libertyPay.horizonSDK.domain.models.RetrievalReferenceNumber
import com.libertyPay.horizonSDK.domain.models.TransactionAmount
import com.libertypay.posclient.api.Environment
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.PluginRegistry
import io.flutter.plugins.Pigeon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EmvService(private val context: Context) : Pigeon.EmvApi,
    PluginRegistry.ActivityResultListener {


    var activityBinding: ActivityPluginBinding? = null
    private var resultCallback: Pigeon.Result<Pigeon.TransactionDataResponse>? = null

    fun initialize(binding: ActivityPluginBinding) {
        activityBinding = binding
        binding.addActivityResultListener(this)
    }

    override fun enquireBalance(
        tID: String,
        accountType: String,
        rrn: String,
        result: Pigeon.Result<Pigeon.TransactionDataResponse>?
    ) {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            LibertyHorizonSDK.initialize(activityBinding!!.activity, environment = Environment.Live)

            delay(1000)
            resultCallback = result
            val accountTypeEnum =
                Constants.transactionTypeMap[accountType] ?: AccountType.DEFAULT_UNSPECIFIED

            activityBinding?.activity?.let {
                LibertyHorizonSDK.startBalanceEnquiryDialogActivity(
                    activity = it,
                    accountType = accountTypeEnum,
                    terminalId = tID,
                    retrievalReferenceNumber = RetrievalReferenceNumber(rrn)
                )
            }
        }

    }

    override fun purchase(
        amount: String,
        accountType: String,
        rrn: String,
        result: Pigeon.Result<Pigeon.TransactionDataResponse>?
    ) {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            LibertyHorizonSDK.initialize(activityBinding!!.activity, environment = Environment.Live)

            delay(1000)
            resultCallback = result
            val accountTypeEnum =
                Constants.transactionTypeMap[accountType] ?: AccountType.DEFAULT_UNSPECIFIED

            activityBinding?.activity?.let {
                LibertyHorizonSDK.startPurchaseActivity(
                    activity = it,
                    transactionAmount = TransactionAmount(amount),
                    accountType = accountTypeEnum,
                    retrievalReferenceNumber = RetrievalReferenceNumber(rrn)
                )
            }
        }

    }


    override fun performKeyExchange(result: Pigeon.Result<Pigeon.KeyExchangeResponse>?) {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            val response = LibertyHorizonSDK.doKeyExchange()
            val state = if (response) DeviceState.SUCCESSFUL.value else DeviceState.ERROR.value
            val keyExchangeResponse = Pigeon.KeyExchangeResponse().apply {
                deviceState = state
                isSuccessful = response
                responseData = mapOf(
                    "message" to "Key exchange service currently unavailable"
                )
            }
            result?.success(keyExchangeResponse)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?): Boolean {
        Log.d(TAG, "onActivityResult: $resultCode")
        Log.d(TAG, "onActivityResult:changed")
        val handler = ActivityResultHandler(resultCallback)
        return handler(data, resultCode, requestCode)
    }


}