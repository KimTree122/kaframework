package com.kim.kaframework.UIpackage.Fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.kim.kaframework.R;

public class EditDialogFragment extends DialogFragment {


    public interface EditDialogListener{
        void OnEditInputComplete(String username, String password);
    }

//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        View view = inflater.inflate(R.layout.dialogfragment_edit_name,null);
//        final EditText mUsername = (EditText) view.findViewById(R.id.id_txt_username);
//        final EditText mPassword = (EditText) view.findViewById(R.id.id_txt_password);
//        builder.setView(view)
//                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        EditDialogListener listener = (EditDialogListener) getActivity();
//                        listener.OnEditInputComplete(mUsername
//                                .getText().toString(), mPassword
//                                .getText().toString());
//                    }
//                }).setNegativeButton("取消",null);
//        return  builder.create();
//    }
}
