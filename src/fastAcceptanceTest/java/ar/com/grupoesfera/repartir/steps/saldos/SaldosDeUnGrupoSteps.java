package ar.com.grupoesfera.repartir.steps.saldos;

import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.steps.FastCucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;


import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SaldosDeUnGrupoSteps extends FastCucumberSteps {

    private Grupo grupo;
    private String error;

    @Dado("un grupo con saldo {int}")
    public void unGrupoConSaldo(int saldo) {
        grupo = new Grupo();
        grupo.setId( 1L );
        grupo.setNombre( "Un grupo con saldo" );

        List<String> miembros = new LinkedList<String>();
        miembros.add( "Miembro 1" );
        miembros.add( "Miembro2" );
        grupo.setMiembros( miembros );

        grupo.setTotal( BigDecimal.valueOf(saldo));
    }

    @Cuando("el usuario agrega un gasto de {int}")
    public void elUsuarioAgregaUnGastoDe(int monto) {
        BigDecimal totalGrupo = grupo.getTotal();
        try {
            grupo.setTotal(totalGrupo.add(BigDecimal.valueOf(monto)));
        } catch (IllegalArgumentException e){
            error = e.getMessage();
        }
    }

    @Entonces("el gasto total del grupo será {double}")
    public void elGastoTotalDelGrupoSera(double totalEsperado) {
        BigDecimal totalGrupo = grupo.getTotal();

        assertThat(totalGrupo.equals(BigDecimal.valueOf(totalEsperado))).isTrue();

    }

    @Entonces("resultará en un error con el mensaje {string}")
    public void resultaEnUnErrorConElMensaje(String mensajeEsperado) {
        assertThat(error.equals(mensajeEsperado)).isTrue();
    }
}
