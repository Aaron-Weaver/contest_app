package andronerds.com.contestapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import andronerds.com.contestapp.cards.AchievementCard;
import andronerds.com.contestapp.fragments.AchievementsFragment;
import andronerds.com.contestapp.fragments.DriveToWinFragment;
import andronerds.com.contestapp.navDrawer.NavDrawerActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author Aaron Weaver         (waaronl@okstate.edu)
 * @version ContestApp v0.1A
 * @since 2/19/15
 */
public class DriveToWinActivity extends NavDrawerActivity
{
    private CharSequence mTitle = "Achievements";

    @InjectView(R.id.drive_to_win_toolbar)Toolbar mToolbar;

    @Override
    protected Toolbar init()
    {
        setContentView(R.layout.activity_drive_to_win);
        ButterKnife.inject(this);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AchievementsFragment achieveFrag = new AchievementsFragment();
        fragmentTransaction.add(R.id.drive_to_win_fragment_container,achieveFrag);
        fragmentTransaction.commit();

        mToolbar.showOverflowMenu();
        mToolbar.setTitle(mTitle);
        setSupportActionBar(mToolbar);

        return mToolbar;
    }
}
