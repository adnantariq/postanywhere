/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nowasys.postanywhere;

import com.nowasys.postanywhere.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Demonstrates a "screen-slide" animation using a {@link ViewPager}. Because
 * {@link ViewPager} automatically plays such an animation when calling
 * {@link ViewPager#setCurrentItem(int)}, there isn't any animation-specific
 * code in this sample.
 * 
 * <p>
 * This sample shows a "next" button that advances the user to the next step in
 * a wizard, animating the current screen out (to the left) and the next screen
 * in (from the right). The reverse animation is played when the user presses
 * the "previous" button.
 * </p>
 * 
 * @see ScreenSlidePageFragment
 */
public class ScreenSlideActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen_slide);

		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// Create the adapter that will return a fragment for each of the three
		// primary sections
		// of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mSectionsPagerAdapter);
		mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				// When changing pages, reset the action bar actions since they
				// are dependent
				// on which page is currently active. An alternative approach is
				// to have each
				// fragment expose actions itself (rather than the activity
				// exposing actions),
				// but for simplicity, the activity provides the actions in this
				// sample.
				// invalidateOptionsMenu();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		// getMenuInflater().inflate(R.menu.activity_screen_slide, menu);
		//
		// menu.findItem(R.id.action_previous).setEnabled(mPager.getCurrentItem()
		// > 0);
		//
		// // Add either a "next" or "finish" button to the action bar,
		// depending
		// // on which page
		// // is currently selected.
		// MenuItem item = menu.add(Menu.NONE, R.id.action_next, Menu.NONE,
		// (mPager.getCurrentItem() == mSectionsPagerAdapter.getCount() - 1) ?
		// R.string.action_finish
		// : R.string.action_next);
		// item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM |
		// MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// Navigate "up" the demo structure to the launchpad activity.
			// See http://developer.android.com/design/patterns/navigation.html
			// for more.
			// NavUtils.navigateUpTo(this, new Intent(this,
			// MainMenuActivity.class));
			finish();
			return true;

			// case R.id.action_previous:
			// // Go to the previous step in the wizard. If there is no previous
			// // step,
			// // setCurrentItem will do nothing.
			// mPager.setCurrentItem(mPager.getCurrentItem() - 1);
			// return true;
			//
			// case R.id.action_next:
			// // Advance to the next step in the wizard. If there is no next
			// step,
			// // setCurrentItem
			// // will do nothing.
			// mPager.setCurrentItem(mPager.getCurrentItem() + 1);
			// return true;
		}

		return super.onOptionsItemSelected(item);
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the primary sections of the app.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int i) {
			Fragment fragment = ScreenSlidePageFragment.create(i + 1);
			Bundle args = new Bundle();
			args.putInt(ScreenSlidePageFragment.ARG_PAGE, i + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase();
			case 1:
				return getString(R.string.title_section2).toUpperCase();
			case 2:
				return getString(R.string.title_section3).toUpperCase();
			case 3:
				return getString(R.string.title_section1).toUpperCase();
			case 4:
				return getString(R.string.title_section2).toUpperCase();
			}
			return null;
		}
	}
}
