package roomescape.dto;

import roomescape.domain.Times;

import java.time.LocalTime;

public record TimeResponse(
        Long id,
        LocalTime time
) {
    public static TimeResponse from(Times times) {
        return new TimeResponse(times.getId(), times.getTime());
    }
}
