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

public final class TicketMenuBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button jednorazowy;

  @NonNull
  public final Button krotkookresowy;

  @NonNull
  public final Button miesieczny;

  @NonNull
  public final Button roczny;

  @NonNull
  public final LinearLayout ticketMenuField;

  @NonNull
  public final Button trzymiesieczny;

  private TicketMenuBinding(@NonNull LinearLayout rootView, @NonNull Button jednorazowy,
      @NonNull Button krotkookresowy, @NonNull Button miesieczny, @NonNull Button roczny,
      @NonNull LinearLayout ticketMenuField, @NonNull Button trzymiesieczny) {
    this.rootView = rootView;
    this.jednorazowy = jednorazowy;
    this.krotkookresowy = krotkookresowy;
    this.miesieczny = miesieczny;
    this.roczny = roczny;
    this.ticketMenuField = ticketMenuField;
    this.trzymiesieczny = trzymiesieczny;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TicketMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TicketMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.ticket_menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TicketMenuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.jednorazowy;
      Button jednorazowy = ViewBindings.findChildViewById(rootView, id);
      if (jednorazowy == null) {
        break missingId;
      }

      id = R.id.krotkookresowy;
      Button krotkookresowy = ViewBindings.findChildViewById(rootView, id);
      if (krotkookresowy == null) {
        break missingId;
      }

      id = R.id.miesieczny;
      Button miesieczny = ViewBindings.findChildViewById(rootView, id);
      if (miesieczny == null) {
        break missingId;
      }

      id = R.id.roczny;
      Button roczny = ViewBindings.findChildViewById(rootView, id);
      if (roczny == null) {
        break missingId;
      }

      LinearLayout ticketMenuField = (LinearLayout) rootView;

      id = R.id.trzymiesieczny;
      Button trzymiesieczny = ViewBindings.findChildViewById(rootView, id);
      if (trzymiesieczny == null) {
        break missingId;
      }

      return new TicketMenuBinding((LinearLayout) rootView, jednorazowy, krotkookresowy, miesieczny,
          roczny, ticketMenuField, trzymiesieczny);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}