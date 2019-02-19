export interface storeList {
  pTitle: string,
  sku: string,
  pn: string,
  price: number,
  picHTML: string,
  hot: number
  features :[productFeature]
}

export interface productFeature {
  title :string,
  text :string,
  media :string,
  orientation :string
}

export interface productFull {
  description :string,
  hero_filename :string
}
