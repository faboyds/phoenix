package phoenix.uniquizandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import phoenix.uniquizandroid.R;
import phoenix.uniquizandroid.activity.QuizzesActivity;
import phoenix.uniquizandroid.dto.FieldDTO;

import phoenix.uniquizandroid.dto.SubjectDTO;


/**
 * Created by Luis Gouveia on 08/09/2017.
 */

public class SubjectCardAdapter extends RecyclerView.Adapter<SubjectCardAdapter.ViewHolder>{

    private Context mContext;
    private SubjectDTO[] mSubjects;

    public SubjectCardAdapter(Context context, SubjectDTO[] subjects){
        this.mContext = context;
        mSubjects = subjects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_card_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SubjectDTO subject = mSubjects[position];
        holder.itemName.setText(subject.getSubjectName());
        holder.extras = new Intent(mContext, QuizzesActivity.class);
        holder.extras.putExtra("subject", subject);
    }

    @Override
    public int getItemCount() {
        return mSubjects.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemName;
        Intent extras;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(extras);
                }
            });
            itemName = (TextView) itemView.findViewById(R.id.item_name);
        }
    }
}

