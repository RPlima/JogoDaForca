package br.edu.ctup.jogodaforca;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btnVerificar;
    private EditText edtLetra;
    private TextView txtLetrasErradas, txtPalavra;
    private ImageView imgforca;
    private final String PALAVRA = "KEIKO";
    private char[] vetorPalavraInteira, vetorPalpite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnVerificar = (Button) findViewById(R.id.btnVerificar);
        edtLetra = (EditText) findViewById(R.id.edtLetra);
        txtLetrasErradas = (TextView) findViewById(R.id.txtLetrasErradas);
        txtPalavra = (TextView) findViewById(R.id.txtPalavra);
        imgforca = (ImageView) findViewById(R.id.imgForca);

        vetorPalavraInteira = PALAVRA.toCharArray();
        vetorPalpite = new char[PALAVRA.length()];
        desenharPalavra();

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String letra = edtLetra.getText().toString().toUpperCase();
                int letrasQuant = 0;

                if (PALAVRA.contains(letra)) {
                    for (int i = 0; i < vetorPalavraInteira.length; i++) {
                        if (vetorPalavraInteira[i] == letra.charAt(0)) {
                            letrasQuant++;
                            vetorPalpite[i] = vetorPalavraInteira[i];
                            Log.i("index", String.valueOf(i));
                        }
                    }

                    String texto = Integer.toString(letrasQuant);
                    Toast.makeText(MainActivity.this, texto, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "essa letra não existe", Toast.LENGTH_SHORT).show();

                }

                String vetor = "";
                for(int i =0; i < vetorPalpite.length; i++){
                    vetor += vetorPalpite[i];
                    Log.i("Vetor",vetor);
                }

            }
        });


    }

    private void desenharPalavra() {

        for (int i = 0; i < PALAVRA.length(); i++) {
            //  palavra[i] = PALAVRA.charAt(i);
            txtPalavra.append("_ ");
        }

    }
}
