package fr.android.androidexercises;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by PierreG on 21/02/17.
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    private LoginActivity activity;

    @InjectMocks
    private LoginPresenter presenter;

    @Test
    public void shouldLoginIfValidPassword() throws Exception {
        String password = "password";
        presenter.checkCredentials(password);

        Mockito.verify(activity).logged();
        Mockito.verify(activity).message(R.string.text_logged);
    }

    @Test
    public void shouldNotLoginIfNullPassword() throws Exception {
        presenter.checkCredentials(null);

        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }

    @Test
    public void shouldNotLoginIfSmallPassword() throws Exception {
        String password = "pa";
        presenter.checkCredentials(password);

        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }

}