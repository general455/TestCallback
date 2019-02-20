package clicksource.ir.testcallback;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {
    Context context;
    List<String> names;
    OnParentClicked onParentClicked;
    public NameAdapter(Context context, List<String> names){
        this.names=names;
        this.context=context;
    }
    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.name_row,viewGroup,false);
        return  new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder nameViewHolder, int i) {

        final String name=names.get(i);
        nameViewHolder.txtName.setText(name);
        nameViewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onParentClicked.onclick(name);
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class NameViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;
        ConstraintLayout constraintLayout;
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=(TextView)itemView.findViewById(R.id.txt_nameRow_name);
            constraintLayout=(ConstraintLayout)itemView.findViewById(R.id.cons_nameRow_parent);
        }
    }

    public interface OnParentClicked{
        void onclick(String name);
    }
}
