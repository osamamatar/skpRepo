package com.osama.skp.utilityClasses.dto;

import com.osama.skp.utilityClasses.info.CustomerInfo;
import com.osama.skp.utilityClasses.info.PaymentInfo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Setter@Getter
public class CustomerDto extends CustomerInfo {

    List<PaymentInfo> paymentInfos;
}
