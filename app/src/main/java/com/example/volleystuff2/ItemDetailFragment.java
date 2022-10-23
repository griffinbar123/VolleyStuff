package com.example.volleystuff2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.volleystuff2.databinding.FragmentItemDetailBinding;
import com.example.volleystuff2.placeholder.PlaceholderContent;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class ItemDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private GriffinModel mItem;
    private CollapsingToolbarLayout mToolbarLayout;
    private TextView mTextView;

    private FragmentItemDetailBinding binding;

    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = PlaceholderContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentItemDetailBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        mToolbarLayout = rootView.findViewById(R.id.toolbar_layout);
        mTextView = binding.itemDetail;

        updateContent();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void updateContent() {
        if (mItem != null) {
            mTextView.setText("Description:\n" + mItem.getDescription());
            if (mToolbarLayout != null) {
                mToolbarLayout.setTitle(mItem.getName());
            }
        }
    }
}