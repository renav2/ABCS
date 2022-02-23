//package com.example.abcs;
//
//public class issue_doc_adpt {
//}
package com.example.abcs;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class issue_doc_adpt extends RecyclerView.Adapter<issue_doc_adpt.myviewholder>
{

    String pro_status;
    ArrayList<issuedoc_data> datalist;
    public issue_doc_adpt(ArrayList<issuedoc_data> datalist) {
        this.datalist = datalist;
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.sutudent_issue_doc_singleline,parent,false);
        return new myviewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
       // TextView yr,date,assno,dept,name,doc;
        holder.yr.setText(datalist.get(position).getYr());
        holder.date.setText(datalist.get(position).getDate());
        holder.assno.setText(datalist.get(position).getRollno());
        holder.dept.setText(datalist.get(position).getDept());
      //  holder.name.setText(datalist.get(position).getUnicid_assignno());
//        holder.t.setText(datalist.get(position).get_1Student_remain_fees());
        holder.name.setText(datalist.get(position).getName());
        holder.doc.setText(datalist.get(position).getDocumentname());
       /// holder.backlog.setText(datalist.get(position).getBacklogformno());


    }
    @Override
    public int getItemCount() {
        return datalist.size();
    }
    class myviewholder extends RecyclerView.ViewHolder
    {
        // add here

TextView yr,date,assno,dept,name,doc;


        FirebaseFirestore fstore;
        TextView permision_Status;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            yr=itemView.findViewById(R.id.year);
            date=itemView.findViewById(R.id.date123131);
            assno=itemView.findViewById(R.id.assignno);
            dept=itemView.findViewById(R.id.dept);
            name=itemView.findViewById(R.id.installment);
            doc=itemView.findViewById(R.id.deptaaaaa);








        }

    }
}
