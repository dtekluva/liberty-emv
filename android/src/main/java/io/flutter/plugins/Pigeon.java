// Autogenerated from Pigeon (v7.2.1), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package io.flutter.plugins;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression"})
public class Pigeon {
  @NonNull
  private static ArrayList<Object> wrapError(@NonNull Throwable exception) {
    ArrayList<Object> errorList = new ArrayList<Object>(3);
    errorList.add(exception.toString());
    errorList.add(exception.getClass().getSimpleName());
    errorList.add(
      "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    return errorList;
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static final class TransactionDataResponse {
    private @Nullable String amount;

    public @Nullable String getAmount() {
      return amount;
    }

    public void setAmount(@Nullable String setterArg) {
      this.amount = setterArg;
    }

    private @Nullable String authorizationCode;

    public @Nullable String getAuthorizationCode() {
      return authorizationCode;
    }

    public void setAuthorizationCode(@Nullable String setterArg) {
      this.authorizationCode = setterArg;
    }

    private @Nullable String cardExpiryDate;

    public @Nullable String getCardExpiryDate() {
      return cardExpiryDate;
    }

    public void setCardExpiryDate(@Nullable String setterArg) {
      this.cardExpiryDate = setterArg;
    }

    private @Nullable String cardHolderName;

    public @Nullable String getCardHolderName() {
      return cardHolderName;
    }

    public void setCardHolderName(@Nullable String setterArg) {
      this.cardHolderName = setterArg;
    }

    private @Nullable String date;

    public @Nullable String getDate() {
      return date;
    }

    public void setDate(@Nullable String setterArg) {
      this.date = setterArg;
    }

    private @Nullable String maskedPan;

    public @Nullable String getMaskedPan() {
      return maskedPan;
    }

    public void setMaskedPan(@Nullable String setterArg) {
      this.maskedPan = setterArg;
    }

    private @Nullable String merchantId;

    public @Nullable String getMerchantId() {
      return merchantId;
    }

    public void setMerchantId(@Nullable String setterArg) {
      this.merchantId = setterArg;
    }

    private @Nullable String merchantName;

    public @Nullable String getMerchantName() {
      return merchantName;
    }

    public void setMerchantName(@Nullable String setterArg) {
      this.merchantName = setterArg;
    }

    private @Nullable String responseCode;

    public @Nullable String getResponseCode() {
      return responseCode;
    }

    public void setResponseCode(@Nullable String setterArg) {
      this.responseCode = setterArg;
    }

    private @Nullable String responseMessage;

    public @Nullable String getResponseMessage() {
      return responseMessage;
    }

    public void setResponseMessage(@Nullable String setterArg) {
      this.responseMessage = setterArg;
    }

    private @Nullable String rrn;

    public @Nullable String getRrn() {
      return rrn;
    }

    public void setRrn(@Nullable String setterArg) {
      this.rrn = setterArg;
    }

    private @Nullable String stan;

    public @Nullable String getStan() {
      return stan;
    }

    public void setStan(@Nullable String setterArg) {
      this.stan = setterArg;
    }

    private @Nullable String terminalId;

    public @Nullable String getTerminalId() {
      return terminalId;
    }

    public void setTerminalId(@Nullable String setterArg) {
      this.terminalId = setterArg;
    }

    private @Nullable String transactionType;

    public @Nullable String getTransactionType() {
      return transactionType;
    }

    public void setTransactionType(@Nullable String setterArg) {
      this.transactionType = setterArg;
    }

    public static final class Builder {

      private @Nullable String amount;

      public @NonNull Builder setAmount(@Nullable String setterArg) {
        this.amount = setterArg;
        return this;
      }

      private @Nullable String authorizationCode;

      public @NonNull Builder setAuthorizationCode(@Nullable String setterArg) {
        this.authorizationCode = setterArg;
        return this;
      }

      private @Nullable String cardExpiryDate;

      public @NonNull Builder setCardExpiryDate(@Nullable String setterArg) {
        this.cardExpiryDate = setterArg;
        return this;
      }

      private @Nullable String cardHolderName;

      public @NonNull Builder setCardHolderName(@Nullable String setterArg) {
        this.cardHolderName = setterArg;
        return this;
      }

      private @Nullable String date;

      public @NonNull Builder setDate(@Nullable String setterArg) {
        this.date = setterArg;
        return this;
      }

      private @Nullable String maskedPan;

      public @NonNull Builder setMaskedPan(@Nullable String setterArg) {
        this.maskedPan = setterArg;
        return this;
      }

      private @Nullable String merchantId;

      public @NonNull Builder setMerchantId(@Nullable String setterArg) {
        this.merchantId = setterArg;
        return this;
      }

      private @Nullable String merchantName;

      public @NonNull Builder setMerchantName(@Nullable String setterArg) {
        this.merchantName = setterArg;
        return this;
      }

      private @Nullable String responseCode;

      public @NonNull Builder setResponseCode(@Nullable String setterArg) {
        this.responseCode = setterArg;
        return this;
      }

      private @Nullable String responseMessage;

      public @NonNull Builder setResponseMessage(@Nullable String setterArg) {
        this.responseMessage = setterArg;
        return this;
      }

      private @Nullable String rrn;

      public @NonNull Builder setRrn(@Nullable String setterArg) {
        this.rrn = setterArg;
        return this;
      }

      private @Nullable String stan;

      public @NonNull Builder setStan(@Nullable String setterArg) {
        this.stan = setterArg;
        return this;
      }

      private @Nullable String terminalId;

      public @NonNull Builder setTerminalId(@Nullable String setterArg) {
        this.terminalId = setterArg;
        return this;
      }

      private @Nullable String transactionType;

      public @NonNull Builder setTransactionType(@Nullable String setterArg) {
        this.transactionType = setterArg;
        return this;
      }

      public @NonNull TransactionDataResponse build() {
        TransactionDataResponse pigeonReturn = new TransactionDataResponse();
        pigeonReturn.setAmount(amount);
        pigeonReturn.setAuthorizationCode(authorizationCode);
        pigeonReturn.setCardExpiryDate(cardExpiryDate);
        pigeonReturn.setCardHolderName(cardHolderName);
        pigeonReturn.setDate(date);
        pigeonReturn.setMaskedPan(maskedPan);
        pigeonReturn.setMerchantId(merchantId);
        pigeonReturn.setMerchantName(merchantName);
        pigeonReturn.setResponseCode(responseCode);
        pigeonReturn.setResponseMessage(responseMessage);
        pigeonReturn.setRrn(rrn);
        pigeonReturn.setStan(stan);
        pigeonReturn.setTerminalId(terminalId);
        pigeonReturn.setTransactionType(transactionType);
        return pigeonReturn;
      }
    }

    @NonNull
    ArrayList<Object> toList() {
      ArrayList<Object> toListResult = new ArrayList<Object>(14);
      toListResult.add(amount);
      toListResult.add(authorizationCode);
      toListResult.add(cardExpiryDate);
      toListResult.add(cardHolderName);
      toListResult.add(date);
      toListResult.add(maskedPan);
      toListResult.add(merchantId);
      toListResult.add(merchantName);
      toListResult.add(responseCode);
      toListResult.add(responseMessage);
      toListResult.add(rrn);
      toListResult.add(stan);
      toListResult.add(terminalId);
      toListResult.add(transactionType);
      return toListResult;
    }

    static @NonNull TransactionDataResponse fromList(@NonNull ArrayList<Object> list) {
      TransactionDataResponse pigeonResult = new TransactionDataResponse();
      Object amount = list.get(0);
      pigeonResult.setAmount((String) amount);
      Object authorizationCode = list.get(1);
      pigeonResult.setAuthorizationCode((String) authorizationCode);
      Object cardExpiryDate = list.get(2);
      pigeonResult.setCardExpiryDate((String) cardExpiryDate);
      Object cardHolderName = list.get(3);
      pigeonResult.setCardHolderName((String) cardHolderName);
      Object date = list.get(4);
      pigeonResult.setDate((String) date);
      Object maskedPan = list.get(5);
      pigeonResult.setMaskedPan((String) maskedPan);
      Object merchantId = list.get(6);
      pigeonResult.setMerchantId((String) merchantId);
      Object merchantName = list.get(7);
      pigeonResult.setMerchantName((String) merchantName);
      Object responseCode = list.get(8);
      pigeonResult.setResponseCode((String) responseCode);
      Object responseMessage = list.get(9);
      pigeonResult.setResponseMessage((String) responseMessage);
      Object rrn = list.get(10);
      pigeonResult.setRrn((String) rrn);
      Object stan = list.get(11);
      pigeonResult.setStan((String) stan);
      Object terminalId = list.get(12);
      pigeonResult.setTerminalId((String) terminalId);
      Object transactionType = list.get(13);
      pigeonResult.setTransactionType((String) transactionType);
      return pigeonResult;
    }
  }

  public interface Result<T> {
    void success(T result);

    void error(Throwable error);
  }

  private static class EmvApiCodec extends StandardMessageCodec {
    public static final EmvApiCodec INSTANCE = new EmvApiCodec();

    private EmvApiCodec() {}

    @Override
    protected Object readValueOfType(byte type, @NonNull ByteBuffer buffer) {
      switch (type) {
        case (byte) 128:
          return TransactionDataResponse.fromList((ArrayList<Object>) readValue(buffer));
        default:
          return super.readValueOfType(type, buffer);
      }
    }

    @Override
    protected void writeValue(@NonNull ByteArrayOutputStream stream, Object value) {
      if (value instanceof TransactionDataResponse) {
        stream.write(128);
        writeValue(stream, ((TransactionDataResponse) value).toList());
      } else {
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
  public interface EmvApi {

    void enquireBalance(@NonNull String tID, @NonNull String accountType, Result<TransactionDataResponse> result);

    void purchase(@NonNull String amount, @NonNull String accountType, Result<TransactionDataResponse> result);

    void performKeyExchange(Result<Boolean> result);

    /** The codec used by EmvApi. */
    static MessageCodec<Object> getCodec() {
      return EmvApiCodec.INSTANCE;
    }
    /**Sets up an instance of `EmvApi` to handle messages through the `binaryMessenger`. */
    static void setup(BinaryMessenger binaryMessenger, EmvApi api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger, "dev.flutter.pigeon.EmvApi.enquireBalance", getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<Object>();
                try {
                  ArrayList<Object> args = (ArrayList<Object>) message;
                  assert args != null;
                  String tIDArg = (String) args.get(0);
                  if (tIDArg == null) {
                    throw new NullPointerException("tIDArg unexpectedly null.");
                  }
                  String accountTypeArg = (String) args.get(1);
                  if (accountTypeArg == null) {
                    throw new NullPointerException("accountTypeArg unexpectedly null.");
                  }
                  Result<TransactionDataResponse> resultCallback = 
                      new Result<TransactionDataResponse>() {
                        public void success(TransactionDataResponse result) {
                          wrapped.add(0, result);
                          reply.reply(wrapped);
                        }

                        public void error(Throwable error) {
                          ArrayList<Object> wrappedError = wrapError(error);
                          reply.reply(wrappedError);
                        }
                      };

                  api.enquireBalance(tIDArg, accountTypeArg, resultCallback);
                } catch (Error | RuntimeException exception) {
                  ArrayList<Object> wrappedError = wrapError(exception);
                  reply.reply(wrappedError);
                }
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger, "dev.flutter.pigeon.EmvApi.purchase", getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<Object>();
                try {
                  ArrayList<Object> args = (ArrayList<Object>) message;
                  assert args != null;
                  String amountArg = (String) args.get(0);
                  if (amountArg == null) {
                    throw new NullPointerException("amountArg unexpectedly null.");
                  }
                  String accountTypeArg = (String) args.get(1);
                  if (accountTypeArg == null) {
                    throw new NullPointerException("accountTypeArg unexpectedly null.");
                  }
                  Result<TransactionDataResponse> resultCallback = 
                      new Result<TransactionDataResponse>() {
                        public void success(TransactionDataResponse result) {
                          wrapped.add(0, result);
                          reply.reply(wrapped);
                        }

                        public void error(Throwable error) {
                          ArrayList<Object> wrappedError = wrapError(error);
                          reply.reply(wrappedError);
                        }
                      };

                  api.purchase(amountArg, accountTypeArg, resultCallback);
                } catch (Error | RuntimeException exception) {
                  ArrayList<Object> wrappedError = wrapError(exception);
                  reply.reply(wrappedError);
                }
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger, "dev.flutter.pigeon.EmvApi.performKeyExchange", getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<Object>();
                try {
                  Result<Boolean> resultCallback = 
                      new Result<Boolean>() {
                        public void success(Boolean result) {
                          wrapped.add(0, result);
                          reply.reply(wrapped);
                        }

                        public void error(Throwable error) {
                          ArrayList<Object> wrappedError = wrapError(error);
                          reply.reply(wrappedError);
                        }
                      };

                  api.performKeyExchange(resultCallback);
                } catch (Error | RuntimeException exception) {
                  ArrayList<Object> wrappedError = wrapError(exception);
                  reply.reply(wrappedError);
                }
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
}
