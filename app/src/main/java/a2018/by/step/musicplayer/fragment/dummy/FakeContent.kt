package a2018.by.step.musicplayer.fragment.dummy

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object FakeContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<FakeItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, FakeItem> = HashMap()

    private val COUNT = 25

    init {
        for (i in 1..COUNT) {
            addItem(createFakeItem(i))
        }
    }

    private fun addItem(item: FakeItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createFakeItem(position: Int): FakeItem {
        return FakeItem(position.toString(), "Item $position", makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0 until position) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class FakeItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}
