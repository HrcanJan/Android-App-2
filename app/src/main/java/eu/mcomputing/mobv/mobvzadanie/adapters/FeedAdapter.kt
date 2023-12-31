package eu.mcomputing.mobv.mobvzadanie.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import eu.mcomputing.mobv.mobvzadanie.R
import eu.mcomputing.mobv.mobvzadanie.data.db.entities.UserEntity
import eu.mcomputing.mobv.mobvzadanie.utils.ItemDiffCallback
import com.bumptech.glide.Glide

class FeedAdapter(context : Context) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {
    private var items: List<UserEntity> = listOf()
    private val context: Context = context

    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.feed_item, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.item_text).text = items[position].name
        val photoName = items[position].photo
        photoName.let{
            val imageUrl = "https://upload.mcomputing.eu/" + photoName
            val imageView = holder.itemView.findViewById<ImageView>(R.id.item_image)
            Glide.with(context)
                .load(imageUrl)
                .into(imageView)
        }

    }

    override fun getItemCount() = items.size

    fun updateItems(newItems: List<UserEntity>) {
        val diffCallback = ItemDiffCallback(items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        items = newItems
        diffResult.dispatchUpdatesTo(this)
    }

}