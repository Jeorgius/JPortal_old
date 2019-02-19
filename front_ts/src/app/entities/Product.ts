
import {productFeature, productFull, storeList} from "../content/interfaces/store";

export class Product implements storeList{
  public id :number;
  public features :[productFeature];
  public storeItemFull :productFull;

  constructor(
    public pTitle :string,
    public sku :string,
    public pn :string,
    public price :number,
    public picHTML :string,
    public hot :number
  ){}
}
