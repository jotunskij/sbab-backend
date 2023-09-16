package se.sbab.sbabbe.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import se.sbab.sbabbe.DTOs.TopLine;

@Service
public interface ILineAndStopService {
    public List<TopLine> getTop10Lines();
}