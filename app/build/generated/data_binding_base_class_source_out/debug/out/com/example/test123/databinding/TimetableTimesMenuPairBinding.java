// Generated by view binder compiler. Do not edit!
package com.example.test123.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.test123.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class TimetableTimesMenuPairBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout timetableTimesMenuPair;

  private TimetableTimesMenuPairBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout timetableTimesMenuPair) {
    this.rootView = rootView;
    this.timetableTimesMenuPair = timetableTimesMenuPair;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TimetableTimesMenuPairBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TimetableTimesMenuPairBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.timetable_times_menu_pair, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TimetableTimesMenuPairBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    LinearLayout timetableTimesMenuPair = (LinearLayout) rootView;

    return new TimetableTimesMenuPairBinding((LinearLayout) rootView, timetableTimesMenuPair);
  }
}