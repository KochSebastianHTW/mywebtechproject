package htwberlin.webtech.service;

import htwberlin.webtech.persistence.LabelEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class LabelTransformerTest implements WithAssertions {

    private final LabelTransformer testPurposes = new LabelTransformer();

    @Test
    @DisplayName("should transform Label Entity to Label")
    void transformLabelEntityToLabel() {
        // given
        var labelEntity = Mockito.mock(LabelEntity.class);
        when(labelEntity.getId()).thenReturn(10L);
        when(labelEntity.getName()).thenReturn("Priorisieren");
        when(labelEntity.getColor()).thenReturn("#FF0000");

        // when
        var result = testPurposes.transformEntity(labelEntity);

        // then
        assertThat(result.getId()).isEqualTo(10L);
        assertThat(result.getName()).isEqualTo("Priorisieren");
        assertThat(result.getColor()).isEqualTo("#FF0000");
    }
}
