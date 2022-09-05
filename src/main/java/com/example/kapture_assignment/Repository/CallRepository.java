package com.example.kapture_assignment.Repository;

import com.example.kapture_assignment.modal.Calls;
import com.example.kapture_assignment.modal.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CallRepository extends JpaRepository<Calls, Integer> {

    @Query(value = "select Hour(start_call) as hour from CALLs where date(start_call) = ?1 group by Hour(start_call) order by count(*) desc limit 1", nativeQuery = true)
    ResultEntity getHourWithHighestVolume(LocalDate date);

    @Query(value = "SELECT SUM(DURATION) as duration, Hour(start_call) as hour FROM CALLs where date(start_call) = ?1 GROUP BY Hour(start_call) order by duration desc limit 1;", nativeQuery = true)
    ResultEntity getHourWithLongestCalls(LocalDate date);

    @Query(value = "SELECT count(*), DAYName(start_call) as day,week(start_call) as week,month(start_call) as month,year(start_call) as year FROM CALLs  GROUP BY date(start_call) order by count(*) desc limit 1;", nativeQuery = true)
    ResultEntity getDayWithLongestVolume();

    @Query(value = "SELECT SUM(duration) as duration , DAYName(start_call) as day,week(start_call) as week,month(start_call) as month,year(start_call) as year FROM CALLs  GROUP BY date(start_call) order by duration desc limit 1;", nativeQuery = true)
    ResultEntity getDayWithLongestDuration();

}