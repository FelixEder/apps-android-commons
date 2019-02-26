package fr.free.nrw.commons;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.free.nrw.commons.kvstore.BasicKvStore;
import fr.free.nrw.commons.quiz.QuizActivity;
import fr.free.nrw.commons.theme.BaseActivity;
import fr.free.nrw.commons.utils.ConfigUtils;

public class WelcomeActivity extends BaseActivity {

    @Inject
    @Named("application_preferences")
    BasicKvStore kvStore;

    @BindView(R.id.welcomePager)
    ViewPager pager;
    @BindView(R.id.welcomePagerIndicator)
    CirclePageIndicator indicator;
    @BindView(R.id.finishTutorialButton)
    TextView finishTutorialButton;

    private WelcomePagerAdapter adapter = new WelcomePagerAdapter();
    private boolean isQuiz;
    static String moreInformation;

    /**
     * Initialises exiting fields and dependencies
     *
     * @param savedInstanceState WelcomeActivity bundled data
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        moreInformation = this.getString(R.string.welcome_help_button_text);

        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                isQuiz = bundle.getBoolean("isQuiz");
            }
        } else {
            isQuiz = false;
        }
        ButterKnife.bind(this);

        // Enable skip button if beta flavor
        if (ConfigUtils.isBetaFlavour()) {
            finishTutorialButton.setVisibility(View.VISIBLE);
        }


        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
        adapter.setCallback(this::finishTutorial);
    }

    /**
     * References WelcomePageAdapter to null before the activity is destroyed
     */
    @Override
    public void onDestroy() {
        if (isQuiz) {
            Intent i = new Intent(WelcomeActivity.this, QuizActivity.class);
            startActivity(i);
        }
        adapter.setCallback(null);
        super.onDestroy();
    }

    /**
     * Creates a way to change current activity to WelcomeActivity
     *
     * @param context Activity context
     */
    public static void startYourself(Context context) {
        Intent welcomeIntent = new Intent(context, WelcomeActivity.class);
        context.startActivity(welcomeIntent);
    }

    /**
     * Override onBackPressed() to go to previous tutorial 'pages' if not on first page
     */
    @Override
    public void onBackPressed() {
        if (pager.getCurrentItem() != 0) {
            pager.setCurrentItem(pager.getCurrentItem() - 1, true);
        } else {
            finish();
        }
    }

    @OnClick(R.id.finishTutorialButton)
    public void finishTutorial() {
        kvStore.putBoolean("firstrun", false);
        finish();
    }
}
