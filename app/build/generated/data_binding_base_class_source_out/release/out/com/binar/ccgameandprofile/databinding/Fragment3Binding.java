// Generated by view binder compiler. Do not edit!
package com.binar.ccgameandprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.binar.ccgameandprofile.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class Fragment3Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnFragment3;

  @NonNull
  public final Guideline guideline;

  @NonNull
  public final ImageView ivIntro3;

  @NonNull
  public final TextView tvIntro1;

  private Fragment3Binding(@NonNull ConstraintLayout rootView, @NonNull Button btnFragment3,
      @NonNull Guideline guideline, @NonNull ImageView ivIntro3, @NonNull TextView tvIntro1) {
    this.rootView = rootView;
    this.btnFragment3 = btnFragment3;
    this.guideline = guideline;
    this.ivIntro3 = ivIntro3;
    this.tvIntro1 = tvIntro1;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static Fragment3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static Fragment3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_3, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static Fragment3Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_fragment_3;
      Button btnFragment3 = rootView.findViewById(id);
      if (btnFragment3 == null) {
        break missingId;
      }

      id = R.id.guideline;
      Guideline guideline = rootView.findViewById(id);
      if (guideline == null) {
        break missingId;
      }

      id = R.id.iv_intro_3;
      ImageView ivIntro3 = rootView.findViewById(id);
      if (ivIntro3 == null) {
        break missingId;
      }

      id = R.id.tv_intro_1;
      TextView tvIntro1 = rootView.findViewById(id);
      if (tvIntro1 == null) {
        break missingId;
      }

      return new Fragment3Binding((ConstraintLayout) rootView, btnFragment3, guideline, ivIntro3,
          tvIntro1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}