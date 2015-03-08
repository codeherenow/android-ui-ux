package com.codeherenow.walkthrough;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Ragunath Jawahar <www.codeherenow.com>
 */
public class WalkthroughItemFragment extends Fragment {

    /*
     * We inflate the pager item layout and return the `View`. This will be used
     * as the root view for the Fragment.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_item_walkthrough, null);
    }
}
