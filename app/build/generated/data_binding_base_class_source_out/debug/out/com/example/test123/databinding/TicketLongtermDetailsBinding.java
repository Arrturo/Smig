// Generated by view binder compiler. Do not edit!
package com.example.test123.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.test123.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TicketLongtermDetailsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout m1;

  @NonNull
  public final Button sendDiscount;

  private TicketLongtermDetailsBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout m1,
      @NonNull Button sendDiscount) {
    this.rootView = rootView;
    this.m1 = m1;
    this.sendDiscount = sendDiscount;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TicketLongtermDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TicketLongtermDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.ticket_longterm_details, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TicketLongtermDetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.m1;
      LinearLayout m1 = ViewBindings.findChildViewById(rootView, id);
      if (m1 == null) {
        break missingId;
      }

      id = R.id.send_discount;
      Button sendDiscount = ViewBindings.findChildViewById(rootView, id);
      if (sendDiscount == null) {
        break missingId;
      }

      return new TicketLongtermDetailsBinding((LinearLayout) rootView, m1, sendDiscount);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}