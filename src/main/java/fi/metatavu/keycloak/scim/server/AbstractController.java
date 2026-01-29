package fi.metatavu.keycloak.scim.server;

import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Abstract controller
 */
public class AbstractController {

    private final String createdAt =  DateTimeFormatter.ISO_INSTANT.format(Instant.now());
    private final String lastModifiedAt = DateTimeFormatter.ISO_INSTANT.format(Instant.now());

    /**
     * Returns meta object
     *
     * @param scimContext SCIM context
     * @param resourceType resource type
     * @param resourcePath resource path
     * @return meta object
     */
    protected fi.metatavu.keycloak.scim.server.model.Meta getMeta(
        ScimContext scimContext,
        String resourceType,
        String resourcePath
    ) {
        fi.metatavu.keycloak.scim.server.model.Meta result = new fi.metatavu.keycloak.scim.server.model.Meta();
        result.setCreated(createdAt);
        result.setLastModified(lastModifiedAt);
        result.setResourceType(resourceType);
        result.setLocation(scimContext.getServerBaseUri().resolve(resourcePath));
        return result;
    }
}
