package com.nowasys.postanywhere.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class FragmentContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<FragmentItem> ITEMS = new ArrayList<FragmentItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, FragmentItem> ITEM_MAP = new HashMap<String, FragmentItem>();

	static {
		// Add 3 sample items.
		addItem(new FragmentItem("1", "Send Card"));
		addItem(new FragmentItem("2", "Send Gift"));
		addItem(new FragmentItem("3", "Invite Friend"));
	}

	private static void addItem(FragmentItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class FragmentItem {
		public String id;
		public String content;

		public FragmentItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}
