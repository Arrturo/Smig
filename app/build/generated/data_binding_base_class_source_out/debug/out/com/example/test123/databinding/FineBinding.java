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

public final class FineBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button historiaMandatW;

  @NonNull
  public final LinearLayout mandaty;

  @NonNull
  public final Button oplacMandat;

  private FineBinding(@NonNull LinearLayout rootView, @NonNull Button historiaMandatW,
      @NonNull LinearLayout mandaty, @NonNull Button oplacMandat) {
    this.rootView = rootView;
    this.historiaMandatW = historiaMandatW;
    this.mandaty = mandaty;
    this.oplacMandat = oplacMandat;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FineBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FineBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.fine, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FineBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.historia_mandatów;
      Button historiaMandatW = ViewBindings.findChildViewById(rootView, id);
      if (historiaMandatW == null) {
        break missingId;
      }

      id = R.id.mandaty;
      LinearLayout mandaty = ViewBindings.findChildViewById(rootView, id);
      if (mandaty == null) {
        break missingId;
      }

      id = R.id.oplac_mandat;
      Button oplacMandat = ViewBindings.findChildViewById(rootView, id);
      if (oplacMandat == null) {
        break missingId;
      }

      return new FineBinding((LinearLayout) rootView, historiaMandatW, mandaty, oplacMandat);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}