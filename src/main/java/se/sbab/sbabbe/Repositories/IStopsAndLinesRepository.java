package se.sbab.sbabbe.Repositories;

import org.springframework.stereotype.Repository;

import se.sbab.sbabbe.DTOs.BaseResponse;
import se.sbab.sbabbe.DTOs.LineStop;
import se.sbab.sbabbe.DTOs.StopPoint;

@Repository
public interface IStopsAndLinesRepository {
    public BaseResponse<StopPoint> getAllStops();
    public BaseResponse<LineStop> getLineStops();
}