export enum StockStatus {
    IN_STOCK = 'IN_STOCK',
    LOW_STOCK = 'LOW_STOCK',
    OUT_OF_STOCK = 'OUT_OF_STOCK',
    DISCONTINUED = 'DISCONTINUED',
    PRE_ORDER = 'PRE_ORDER'
}


export enum StockUpdateReason {
    PURCHASE = 'PURCHASE',
    RESTOCK = 'RESTOCK',
    RETURN = 'RETURN',
    DAMAGED = 'DAMAGED',
    ADJUSTMENT = 'ADJUSTMENT',
    TRANSFER = 'TRANSFER'
}