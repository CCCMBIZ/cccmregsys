package biz.cccm.registration.domain;

import java.io.Serializable;

public class Seminar implements Serializable {
    private String session1 ;
    private String session2 ;
    private String session3 ;
    private String session4 ;

    /**
     * @return the session1
     */
    public String getSession1() {
        return session1;
    }

    /**
     * @param session1 the session1 to set
     */
    public void setSession1(String session1) {
        this.session1 = session1;
    }

    /**
     * @return the session2
     */
    public String getSession2() {
        return session2;
    }

    /**
     * @param session2 the session2 to set
     */
    public void setSession2(String session2) {
        this.session2 = session2;
    }

    /**
     * @return the session3
     */
    public String getSession3() {
        return session3;
    }

    /**
     * @param session3 the session3 to set
     */
    public void setSession3(String session3) {
        this.session3 = session3;
    }

    /**
     * @return the session4
     */
    public String getSession4() {
        return session4;
    }

    /**
     * @param session4 the session4 to set
     */
    public void setSession4(String session4) {
        this.session4 = session4;
    }

}
//public enum Seminar implements Serializable {
//    A1, A2, B1, B2, C, D, E, F, G1, G2, H, I1, I2, J, K, L, M, N, O, P, Q, R, S, T, U1, U2, V1, V2, W, X, Y, Z;
//}
