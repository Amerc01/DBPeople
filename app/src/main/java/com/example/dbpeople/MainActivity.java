package com.example.dbpeople;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    AlertDialog.Builder alertError;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DatabaseManager.connect();

        EditText nameField = findViewById(R.id.name);
        EditText surnameField = findViewById(R.id.surname);
        EditText emailField = findViewById(R.id.email);
        EditText cfField = findViewById(R.id.cf);
        EditText usernameField = findViewById(R.id.username);
        EditText passwordField = findViewById(R.id.password);
        EditText repasswordField = findViewById(R.id.repassword);

        RadioButton maleField = findViewById(R.id.male);
        RadioButton femaleField = findViewById(R.id.female);
        RadioGroup genderField = findViewById(R.id.gender);

        Button saveField = findViewById(R.id.save);
        Button cancelField = findViewById(R.id.cancel);

        EditText resultField = findViewById(R.id.resultField);

        cancelField.setOnClickListener(
                view -> {
                    nameField.setText("");
                    surnameField.setText("");
                    emailField.setText("");
                    cfField.setText("");
                    usernameField.setText("");
                    passwordField.setText("");
                    repasswordField.setText("");
                    genderField.clearCheck();
                }
        );

        AlertDialog.Builder alertOk = new AlertDialog.Builder(this).setTitle("Successo")
                .setMessage("Registrazione avvenuta con successo!")
                // aggiungo i button per farvi capire come sono posizionati
                .setPositiveButton("positive", this);

        alertError =  new AlertDialog.Builder(this).setTitle("Errore");


        saveField.setOnClickListener(
                view -> {
                    final String name = nameField.getText().toString();
                    final String surname = surnameField.getText().toString();
                    final String email = emailField.getText().toString();
                    final String cf = cfField.getText().toString();
                    final String username = usernameField.getText().toString();
                    final String password = passwordField.getText().toString();
                    final String repassword = repasswordField.getText().toString();
                    String gender;

                    if (maleField.isChecked()) gender = "male";
                    else if (femaleField.isChecked()) gender = "female";
                    else gender = "unknown";

                    if (!name.equals("") && !surname.equals("") && !cf.equals("") && !username.equals("")
                            && !password.equals("") && !repassword.equals("") && !email.equals("")) {

                        if (password.equals(repassword)) {
                            UsernameChecker usernameChecker = new UsernameChecker();

                            if (!usernameChecker.check(DatabaseManager.connection, username)) {
                                try {
                                    Statement statementInsert = DatabaseManager.connection.createStatement();
                                    statementInsert.executeUpdate("INSERT INTO `peopledatas`(" +
                                            "`name`," +
                                            " `surname`," +
                                            " `email`," +
                                            " `cf`," +
                                            " `username`," +
                                            " `gender`) " +
                                            "VALUES (" + "'" +
                                            name + "'," + "'" +
                                            surname + "'," + "'" +
                                            email + "'," + "'" +
                                            cf + "'," + "'" +
                                            username + "'," + "'" +
                                            gender + "')"
                                    );

                                    String hashedPw = Hashing.toHexString(Hashing.getSHA(password));
                                    statementInsert.executeUpdate("INSERT INTO `credentials`(" +
                                            "`username`," +
                                            " `hashed_pw`," +
                                            "VALUES ('" + "'" +
                                            username + "''" +
                                            hashedPw + "'"
                                    );

                                    alertOk.show();

                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            } else alertError.setMessage("Utente già registrato");

                        } else alertError.setMessage("Password diverse");

                    } else alertError.setMessage("Dati mancanti");

                }
        );
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        if (i == AlertDialog.BUTTON_POSITIVE) {   //i = -1
            alert.setMessage("premuto positive button");
        }
        alert.show();
    }
}

/*TODO
seconda activity per login
*  */