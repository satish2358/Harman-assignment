package com.harman.testapp.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.harman.testapp.R;
import com.harman.testapp.model.PatientDetails;

import java.util.List;

public class PatientAdapt extends RecyclerView.Adapter<PatientAdapt.PatientAdaptViewHolder> {

    private List<PatientDetails> list;

    public PatientAdapt(List<PatientDetails> list) {
        this.list = list;
    }

    @Override
    public PatientAdaptViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.activity_patient_list_new, parent, false);
        return new PatientAdaptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PatientAdaptViewHolder holder,final int position) {
        final PatientDetails patient = list.get(position);

        holder.bind(patient);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean expanded = patient.isExpanded();
                boolean exp = !expanded;
                patient.setExpanded(exp);
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class PatientAdaptViewHolder extends RecyclerView.ViewHolder {

        private TextView firstname, lastname, bed, bay, clinician;
        private TextView address;
        private TextView nhs_number;
        private View subItem;

        public PatientAdaptViewHolder(View itemView) {
            super(itemView);
            clinician = itemView.findViewById(R.id.clinician);
            firstname = itemView.findViewById(R.id.first_name);
            lastname = itemView.findViewById(R.id.last_name);
            address = itemView.findViewById(R.id.address);
            bed = itemView.findViewById(R.id.bed);
            bay = itemView.findViewById(R.id.bay);
            nhs_number = itemView.findViewById(R.id.nhs_number);
            subItem = itemView.findViewById(R.id.sub_item);
        }

        private void bind(PatientDetails patient) {
            boolean expanded = patient.isExpanded();

            subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);
            subItem.setBackgroundColor(Color.rgb(0,126,191));
            firstname.setText(patient.getPatientGivenName() );
            clinician.setText(patient.getClinician().getFullName());
            lastname.setText(patient.getPatientFamilyName()+" ,");
            address.setText(patient.getSiteName() +"\n"+ patient.getAreaName());
            bed.setText(patient.getBed());
            bay.setText(patient.getBay());
            nhs_number.setText( patient.getPatientIdentifiers().getPrimaryIdentifier().getValue());
        }
    }
}