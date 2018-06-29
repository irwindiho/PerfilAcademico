package com.irvinmarin.apps.miperfilacademico.login.domain_usecases;


import com.irvinmarin.apps.miperfilacademico.base.UseCase;
import com.irvinmarin.apps.miperfilacademico.login.data_source.LoginRepository;
import com.irvinmarin.apps.miperfilacademico.login.data_source.callbacks.GetUsuarioInitCallback;

/**
 * Created by irvinmarin on 03/10/2017.
 */

public class GetUsuarioInitUI extends UseCase<GetUsuarioInitUI.RequestValues, GetUsuarioInitUI.ResponseValue> {

    private LoginRepository repository;

    public GetUsuarioInitUI(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {

        repository.getUsuarioUIData(requestValues,
                new GetUsuarioInitCallback() {
                    @Override
                    public void onUsuarioCorrect(boolean isSuccess) {
                        getUseCaseCallback().onSuccess(new ResponseValue(isSuccess));
                    }

                    @Override
                    public void onError(String error) {
                        getUseCaseCallback().onError();
                    }
                });

    }

    public static final class RequestValues implements UseCase.RequestValues {
        private final String userName;
        private final String password;

        public RequestValues(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }
    }

    public static final class ResponseValue implements UseCase.ResponseValue {
        private final boolean isSuccess;

        public ResponseValue(boolean isSuccess) {
            this.isSuccess = isSuccess;
        }

        public boolean isSuccess() {
            return isSuccess;
        }
    }
}
