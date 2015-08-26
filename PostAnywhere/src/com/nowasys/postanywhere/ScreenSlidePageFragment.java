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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A fragment representing a single step in a wizard. The fragment shows a dummy
 * title indicating the page number, along with some dummy text.
 * 
 * <p>
 * This class is used by the {@link CardFlipActivity} and
 * {@link ScreenSlideActivity} samples.
 * </p>
 */
public class ScreenSlidePageFragment extends Fragment {
	/**
	 * The argument key for the page number this fragment represents.
	 */
	public static final String ARG_PAGE = "page";

	/**
	 * The fragment's page number, which is set to the argument value for
	 * {@link #ARG_PAGE}.
	 */
	private int mPageNumber;

	/**
	 * Factory method for this fragment class. Constructs a new fragment for the
	 * given page number.
	 */
	public static Fragment create(int pageNumber) {
		Fragment fragment = new ScreenSlidePageFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_PAGE, pageNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public ScreenSlidePageFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPageNumber = getArguments().getInt(ARG_PAGE);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout containing a title and body text.
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);

		if (rootView != null) {
			// Set the title view to show the page number.
			if (mPageNumber == 1) {
				// rootView.findViewById(R.id.imageViewTheme).setBackgroundResource(R.drawable.blue);
				rootView.findViewById(R.id.button_apply).setBackgroundResource(R.drawable.ic_launcher);
				rootView.findViewById(R.id.imageViewThemeTopBar).setBackgroundResource(R.drawable.image1);
				((TextView) rootView.findViewById(R.id.textViewTitle)).setText("BLUE");

				// rootView.setBackgroundResource(R.drawable.blue);
			} else if (mPageNumber == 2) {
				// rootView.findViewById(R.id.imageViewTheme).setBackgroundResource(R.drawable.grey);
				rootView.findViewById(R.id.button_apply).setBackgroundResource(R.drawable.ic_launcher);
				rootView.findViewById(R.id.imageViewThemeTopBar).setBackgroundResource(R.drawable.image2);
				((TextView) rootView.findViewById(R.id.textViewTitle)).setText("GREY");
			} else if (mPageNumber == 3) {
				// rootView.findViewById(R.id.imageViewTheme).setBackgroundResource(R.drawable.green);
				rootView.findViewById(R.id.button_apply).setBackgroundResource(R.drawable.ic_launcher);
				rootView.findViewById(R.id.imageViewThemeTopBar).setBackgroundResource(R.drawable.image3);
				((TextView) rootView.findViewById(R.id.textViewTitle)).setText("GREEN");
			} else if (mPageNumber == 4) {
				// rootView.findViewById(R.id.imageViewTheme).setBackgroundResource(R.drawable.orange);
				rootView.findViewById(R.id.button_apply).setBackgroundResource(R.drawable.ic_launcher);
				rootView.findViewById(R.id.imageViewThemeTopBar).setBackgroundResource(R.drawable.image4);
				((TextView) rootView.findViewById(R.id.textViewTitle)).setText("ORANGE");
			}
		}
		return rootView;
	}

	/**
	 * Returns the page number represented by this fragment object.
	 */
	public int getPageNumber() {
		return mPageNumber;
	}
}
