// Generated by view binder compiler. Do not edit!
package com.example.test123.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.test123.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ClientAddDiscountBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Spinner discountSpinner;

  @NonNull
  public final TextInputEditText email;

  @NonNull
  public final Button sendDiscount;

  private ClientAddDiscountBinding(@NonNull LinearLayout rootView, @NonNull Spinner discountSpinner,
      @NonNull TextInputEditText email, @NonNull Button sendDiscount) {
    this.rootView = rootView;
    this.discountSpinner = discountSpinner;
    this.email = email;
    this.sendDiscount = sendDiscount;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ClientAddDiscountBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ClientAddDiscountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.client_add_discount, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ClientAddDiscountBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.discount_spinner;
      Spinner discountSpinner = ViewBindings.findChildViewById(rootView, id);
      if (discountSpinner == null) {
        break missingId;
      }

      id = R.id.email;
      TextInputEditText email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.send_discount;
      Button sendDiscount = ViewBindings.findChildViewById(rootView, id);
      if (sendDiscount == null) {
        break missingId;
      }

      return new ClientAddDiscountBinding((LinearLayout) rootView, discountSpinner, email,
          sendDiscount);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
