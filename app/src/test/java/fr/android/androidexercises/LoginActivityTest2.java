package fr.android.androidexercises;

import android.widget.TextView;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.robolectric.Robolectric;

/**
 * Created by PierreG on 21/02/17.
 *
 */
@RunWith(CustomRobolectricTestRunner.class)
public class LoginActivityTest2 {

    @Mock
    private LoginPresenter presenter;

    @InjectMocks
    private LoginActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void should_set_logged_state() throws Exception {
        activity.logged();

        Assertions.assertThat(activity.loginLayout).isGone();
        Assertions.assertThat(activity.loggedText).isVisible();
    }

    @Test
    public void should_set_not_logged_state() throws Exception {
        activity.notLogged();

        Assertions.assertThat(activity.loginLayout).isVisible();
        Assertions.assertThat(activity.loggedText).isGone();
    }

    @Test
    public void should_check_credentials_onclick() throws Exception {
        activity.passwordEdit.setText("login");
        ((TextView)activity.loggedText).setText("password");
        activity.findViewById(R.id.loginButton).performClick();

        //verify(presenter).checkCredentials("password");
        Assertions.assertThat(activity.loginLayout).isGone();
        Assertions.assertThat(activity.loggedText).isVisible();
    }

}