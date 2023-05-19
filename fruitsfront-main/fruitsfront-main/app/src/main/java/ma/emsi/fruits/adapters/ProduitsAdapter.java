package ma.emsi.fruits.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProduitsAdapter extends RecyclerView.Adapter<ProduitsAdapter.ProduitsViewHolder> {

    @NonNull
    @Override
    public ProduitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ProduitsViewHolder extends RecyclerView.ViewHolder {
        public ProduitsViewHolder(View itemView) {
            super(itemView);
        }
    }
}
