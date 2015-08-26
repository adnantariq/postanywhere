package com.nowasys.postanywhere;

import com.nowasys.postanywhere.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * An activity representing a list of Items. This activity has different
 * presentations for handset and tablet-size devices. On handsets, the activity
 * presents a list of items, which when touched, lead to a
 * {@link postDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two
 * vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link postListFragment} and the item details (if present) is a
 * {@link postDetailFragment}.
 * <p>
 * This activity also implements the required {@link postListFragment.Callbacks}
 * interface to listen for item selections.
 */
public class postListActivity extends Activity implements postListFragment.Callbacks {

	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
	 * device.
	 */
	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post_list);

		if (findViewById(R.id.post_detail_container) != null) {
			// The detail container view will be present only in the
			// large-screen layouts (res/values-large and
			// res/values-sw600dp). If this view is present, then the
			// activity should be in two-pane mode.
			mTwoPane = true;

			// In two-pane mode, list items should be given the
			// 'activated' state when touched.
			((postListFragment) getFragmentManager().findFragmentById(R.id.post_list)).setActivateOnItemClick(true);
		}

		// TODO: If exposing deep links into your app, handle intents here.
	}

	/**
	 * Callback method from {@link postListFragment.Callbacks} indicating that
	 * the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(String id) {
		if (mTwoPane) {
			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putString(postDetailFragment.ARG_ITEM_ID, id);
			postDetailFragment fragment = new postDetailFragment();
			fragment.setArguments(arguments);
			getFragmentManager().beginTransaction().replace(R.id.post_detail_container, fragment).commit();

		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			// Intent detailIntent = new Intent(this, postDetailActivity.class);
			// detailIntent.putExtra(postDetailFragment.ARG_ITEM_ID, id);
			if (id != null && id.length() > 0) {
				int itemNumber = Integer.parseInt(id);
				switch (itemNumber) {
				case 1:
					Intent intentSendPostCard = new Intent(this, ScreenSlideActivity.class);
					intentSendPostCard.putExtra(postDetailFragment.ARG_ITEM_ID, id);
					startActivity(intentSendPostCard);
					break;
				case 2:
					Intent intentSendPostGift = new Intent(this, ScreenSlideActivity.class);
					intentSendPostGift.putExtra(postDetailFragment.ARG_ITEM_ID, id);
					startActivity(intentSendPostGift);
					break;
				case 3:
					Intent intentInvite = new Intent(this, ScreenSlideActivity.class);
					intentInvite.putExtra(postDetailFragment.ARG_ITEM_ID, id);
					startActivity(intentInvite);
					break;
				}
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_tab, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
