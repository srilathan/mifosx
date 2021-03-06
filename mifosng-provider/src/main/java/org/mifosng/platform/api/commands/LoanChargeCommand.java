package org.mifosng.platform.api.commands;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;

/**
 * Immutable command for creating and updating loan charges.
 */
public class LoanChargeCommand {

    private final Long id;
    private final Long chargeId;
    private final Long loanId;
    private final BigDecimal amount;

    private final Integer chargeTimeType;
    private final LocalDate specifiedDueDate;
    private final Integer chargeCalculationType;

    /**
     * Used to capture what parameters were passed in the json api request. 
     * It does not indicate that these values are modified from their original values when tyring to update.
     */
    private final Set<String> requestParameters;
    
    public static LoanChargeCommand forWaiver(final Long id, final Long loanId) {
		final Set<String> parametersPassedInCommand = new HashSet<String>();
		return new LoanChargeCommand(parametersPassedInCommand, id, loanId, null, null, null, null, null);
	}

    public LoanChargeCommand(
    		final Set<String> parametersPassedInCommand, 
    		final Long id, 
    		final Long loanId, 
    		final Long chargeId, 
    		final BigDecimal amount, 
    		final Integer chargeTimeType, 
    		final Integer chargeCalculationType, 
    		final LocalDate specifiedDueDate) {
        this.requestParameters = parametersPassedInCommand;
        this.id = id;
        this.chargeId = chargeId;
        this.loanId = loanId;
        this.amount = amount;
        this.chargeTimeType = chargeTimeType;
        this.chargeCalculationType = chargeCalculationType;
		this.specifiedDueDate = specifiedDueDate;
    }

    public Long getId() {
        return id;
    }

    public Long getChargeId() {
        return chargeId;
    }

    public Long getLoanId() {
        return loanId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getChargeTimeType() {
        return chargeTimeType;
    }
    
    public LocalDate getSpecifiedDueDate() {
		return specifiedDueDate;
	}

	public Integer getChargeCalculationType() {
        return chargeCalculationType;
    }

    public boolean isAmountChanged(){
        return this.requestParameters.contains("amount");
    }

    public boolean isChargeTimeTypeChanged(){
        return this.requestParameters.contains("chargeTimeType");
    }
    
    public boolean isSpecifiedDueDateChanged(){
        return this.requestParameters.contains("specifiedDueDate");
    }

    public boolean isChargeCalculationTypeChanged(){
        return this.requestParameters.contains("chargeCalculationType");
    }
}