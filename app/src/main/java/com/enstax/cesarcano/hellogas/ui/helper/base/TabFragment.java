package com.enstax.cesarcano.hellogas.ui.helper.base;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;

import com.enstax.cesarcano.hellogas.R;

/**
 * Created by cesar on 29/04/18.
 */

public class TabFragment extends Fragment {
    public ProgressDialog mProgressDialog;
    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCancelable(false);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }
}
