package ugb.sat.madsi;

import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import ugb.sat.madsi.domain.Car;

@RepositoryEventHandler
public class CarEventHandler {

    @HandleBeforeDelete
    public void handleCarBeforeDelete(Car car) {
        // Ici, tu peux ajouter une logique avant suppression si besoin (ex. validation).
        // Rien à faire ici pour simplement obtenir 204.
    }
}