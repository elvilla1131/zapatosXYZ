package com.elvilla.zapatosxyz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class principal extends AppCompatActivity {
    private EditText cantidad;
    private TextView valorUnitario, valorTotal;
    private Spinner tipo, marca, sexo, moneda;
    private String[] strTipo, strMarca, strSexo, strMoneda;
    private ArrayAdapter adapter_Tipo, adapter_Marca, adapter_Sexo, adapter_moneda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        cantidad = (EditText)findViewById(R.id.txtCantidad);
        valorTotal = (TextView) findViewById(R.id.txtValorTotal);
        valorUnitario = (TextView)findViewById(R.id.txtValorUnitario);
        tipo = (Spinner)findViewById(R.id.cmbTipo);
        marca = (Spinner)findViewById(R.id.cmbMarca);
        sexo = (Spinner)findViewById(R.id.cmbSexo);
        moneda = (Spinner)findViewById(R.id.cmbMoneda);

        strTipo = this.getResources().getStringArray(R.array.strTipo);
        strSexo = this.getResources().getStringArray(R.array.strSexo);
        strMarca = this.getResources().getStringArray(R.array.strMarca);
        strMoneda = this.getResources().getStringArray(R.array.strMoneda);
        adapter_Tipo = new ArrayAdapter(this,android.R.layout.simple_list_item_1, strTipo);
        adapter_Sexo = new ArrayAdapter(this,android.R.layout.simple_list_item_1, strSexo);
        adapter_Marca = new ArrayAdapter(this,android.R.layout.simple_list_item_1, strMarca);
        adapter_moneda = new ArrayAdapter(this,android.R.layout.simple_list_item_1, strMoneda);

        tipo.setAdapter(adapter_Tipo);
        marca.setAdapter(adapter_Marca);
        sexo.setAdapter(adapter_Sexo);
        moneda.setAdapter(adapter_moneda);
    }
    public void calcular(View v){
        int op_tipo, op_marca, op_sexo, op_moneda;
        double cant, resultado = 0;

        if (validar()){
            cant = Double.parseDouble(cantidad.getText().toString());
            op_tipo = tipo.getSelectedItemPosition();
            op_marca= marca.getSelectedItemPosition();
            op_sexo = sexo.getSelectedItemPosition();
            op_moneda = moneda.getSelectedItemPosition();
            switch (op_tipo){
                case 0:
                    switch (op_sexo){
                        case 0:
                            switch (op_marca){
                                case 0:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 120000 * cant;
                                            break;
                                        case 1:
                                            resultado = 42 * cant;
                                            break;
                                    }
                                    break;
                                case 1:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 140000 * cant;
                                            break;
                                        case 1:
                                            resultado = 49 * cant;
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 130000 * cant;
                                            break;
                                        case 1:
                                            resultado = 45 * cant;
                                            break;
                                    }
                                    break;
                            }
                            break;
                        case 1:
                            switch (op_marca){
                                case 0:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 100000 * cant;
                                            break;
                                        case 1:
                                            resultado = 35 * cant;
                                            break;
                                    }
                                    break;
                                case 1:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 130000 * cant;
                                            break;
                                        case 1:
                                            resultado = 45 * cant;
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 110000 * cant;
                                            break;
                                        case 1:
                                            resultado = 38.50 * cant;
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;

                case 1:
                    switch (op_sexo){
                        case 0:
                            switch (op_marca){
                                case 0:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 50000 * cant;
                                            break;
                                        case 1:
                                            resultado = 17.50 * cant;
                                            break;
                                    }
                                    break;
                                case 1:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 80000 * cant;
                                            break;
                                        case 1:
                                            resultado = 28 * cant;
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 100000 * cant;
                                            break;
                                        case 1:
                                            resultado = 35 * cant;
                                            break;
                                    }
                                    break;
                            }
                            break;
                        case 1:
                            switch (op_marca){
                                case 0:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 60000 * cant;
                                            break;
                                        case 1:
                                            resultado = 21 * cant;
                                            break;
                                    }
                                    break;
                                case 1:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 70000 * cant;
                                            break;
                                        case 1:
                                            resultado = 24.50 * cant;
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 120000 * cant;
                                            break;
                                        case 1:
                                            resultado = 42 * cant;
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
            valorTotal.setText(""+resultado);
            valorUnitario.setText(""+resultado/cant);
        }
    }

    public boolean validar(){
        if (cantidad.getText().toString().isEmpty()){
            cantidad.requestFocus();
            cantidad.setError("Digite una cantidad minima de 1");
            return false;
        }
        if (Integer.parseInt(cantidad.getText().toString())==0){
            cantidad.requestFocus();
            cantidad.setError("Digite un valor superior a cero");
            return false;
        }
        return true;
    }

    public void borrar(View v){
        cantidad.setText("");
        valorUnitario.setText("");
        valorTotal.setText("");
        cantidad.requestFocus();
        tipo.setSelection(0);
        marca.setSelection(0);
        sexo.setSelection(0);
        moneda.setSelection(0);


    }
}
