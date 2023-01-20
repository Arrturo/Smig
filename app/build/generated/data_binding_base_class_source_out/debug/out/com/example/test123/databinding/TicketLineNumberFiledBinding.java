// Generated by view binder compiler. Do not edit!
package com.example.test123.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.test123.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TicketLineNumberFiledBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextInputEditText ticketLineNumber;

  @NonNull
  public final LinearLayout ticketsLineNumberFiled;

  private TicketLineNumberFiledBinding(@NonNull LinearLayout rootView,
      @NonNull TextInputEditText ticketLineNumber, @NonNull LinearLayout ticketsLineNumberFiled) {
    this.rootView = rootView;
    this.ticketLineNumber = ticketLineNumber;
    this.ticketsLineNumberFiled = ticketsLineNumberFiled;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TicketLineNumberFiledBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TicketLineNumberFiledBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.ticket_line_number_filed, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TicketLineNumberFiledBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ticket_line_number;
      TextInputEditText ticketLineNumber = ViewBindings.findChildViewById(rootView, id);
      if (ticketLineNumber == null) {
        break missingId;
      }

      LinearLayout ticketsLineNumberFiled = (LinearLayout) rootView;

      return new TicketLineNumberFiledBinding((LinearLayout) rootView, ticketLineNumber,
          ticketsLineNumberFiled);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}