// Generated by view binder compiler. Do not edit!
package com.binar.ccgameandprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.binar.ccgameandprofile.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnLogin;

  @NonNull
  public final Button btnReset;

  @NonNull
  public final EditText etEmail;

  @NonNull
  public final EditText etPassword;

  @NonNull
  public final Guideline guideline;

  @NonNull
  public final ImageView ivLogin;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnLogin,
      @NonNull Button btnReset, @NonNull EditText etEmail, @NonNull EditText etPassword,
      @NonNull Guideline guideline, @NonNull ImageView ivLogin) {
    this.rootView = rootView;
    this.btnLogin = btnLogin;
    this.btnReset = btnReset;
    this.etEmail = etEmail;
    this.etPassword = etPassword;
    this.guideline = guideline;
    this.ivLogin = ivLogin;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_login;
      Button btnLogin = rootView.findViewById(id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.btn_reset;
      Button btnReset = rootView.findViewById(id);
      if (btnReset == null) {
        break missingId;
      }

      id = R.id.et_email;
      EditText etEmail = rootView.findViewById(id);
      if (etEmail == null) {
        break missingId;
      }

      id = R.id.et_password;
      EditText etPassword = rootView.findViewById(id);
      if (etPassword == null) {
        break missingId;
      }

      id = R.id.guideline;
      Guideline guideline = rootView.findViewById(id);
      if (guideline == null) {
        break missingId;
      }

      id = R.id.iv_login;
      ImageView ivLogin = rootView.findViewById(id);
      if (ivLogin == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, btnLogin, btnReset, etEmail,
          etPassword, guideline, ivLogin);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
