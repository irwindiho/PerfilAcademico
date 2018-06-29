package com.irvinmarin.apps.miperfilacademico.main.domain_usecases;


import com.irvinmarin.apps.miperfilacademico.base.UseCase;
import com.irvinmarin.apps.miperfilacademico.main.data_source.MainRepository;
import com.irvinmarin.apps.miperfilacademico.main.data_source.callbacks.GetUsuarioSesionCallback;
import com.irvinmarin.apps.miperfilacademico.main.ui.entities.UsuarioUI;

/**
 * Created by irvinmarin on 03/10/2017.
 */

public class GetUsuarioUISesion extends UseCase<GetUsuarioUISesion.RequestValues, GetUsuarioUISesion.ResponseValue> {

    private MainRepository repository;

    public GetUsuarioUISesion(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {

        repository.getUsuarioSesionUIData(requestValues,
                new GetUsuarioSesionCallback() {
                    @Override
                    public void onUsuarioSesionLoaded(UsuarioUI usuarioUI) {
                        getUseCaseCallback().onSuccess(new ResponseValue(usuarioUI));

                    }

                    @Override
                    public void onError(String error) {
                        getUseCaseCallback().onError();

                    }
                });


    }

    public static final class RequestValues implements UseCase.RequestValues {

        public RequestValues() {
        }
    }

    public static final class ResponseValue implements UseCase.ResponseValue {
        private final UsuarioUI usuarioUI;

        public ResponseValue(UsuarioUI usuarioUI) {
            this.usuarioUI = usuarioUI;
        }

        public UsuarioUI getUsuarioUI() {
            return usuarioUI;
        }
    }
}
