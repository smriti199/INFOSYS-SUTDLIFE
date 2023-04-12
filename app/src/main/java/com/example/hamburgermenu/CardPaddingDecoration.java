package com.example.hamburgermenu;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class CardPaddingDecoration extends RecyclerView.ItemDecoration {
    private final int nPadding;

    public CardPaddingDecoration(int Padding) {
        this.nPadding = Padding;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(nPadding, nPadding, nPadding, nPadding);
    }
}
