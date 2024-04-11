package cc.maids.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int batteryPower;

    @Column
    private int blue;

    @Column
    private double clockSpeed;

    @Column
    private int dualSim;

    @Column
    private int fc;

    @Column
    private int fourG;

    @Column
    private int intMemory;

    @Column
    private double mDep;

    @Column
    private int mobileWt;

    @Column
    private int nCores;

    @Column
    private int pc;

    @Column
    private int pxHeight;

    @Column
    private int pxWidth;

    @Column
    private int ram;

    @Column
    private int scH;

    @Column
    private int scW;

    @Column
    private int talkTime;

    @Column
    private int threeG;

    @Column
    private int touchScreen;

    @Column
    private int wifi;

    @Column(nullable = true)
    private Integer priceRange;
}