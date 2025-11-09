import { useEffect, useState } from 'react'
import './App.css'
import ProductList from './ProductList';
import CategoryFilter from './CategoryFilter';

function App() {

  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);

  const [selectedCategory, setSelectedCategories] = useState([null]);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  //js 
  useEffect(()=>{
  fetch('http://localhost:8081/api/products') // useing fetch to do api call to backend
    .then(response => response.json()) // getting response in json
    .then(data => setProducts(data));

    fetch('http://localhost:8081/api/categories') // useing fetch to do api call to backend
    .then(response => response.json()) // getting response in json
    .then(data => setCategories(data));
},[]);


  const handleSearchChange = (event) =>{
    setSearchTerm(event.target.value);
  };

  const handleSortChange = (event) =>{
    setSortOrder(event.target.value);
  };

  const handleCategorySelect = (categoryId) =>{
    setSelectedCategories(categoryId ? Number(categoryId) : null);
  };

  const filteredProducts = products
  .filter(product => selectedCategory ? product.categoryId === selectedCategory : true)
  .filter(product => product.name.toLowerCase().includes(searchTerm.toLowerCase())) // ✅ Search support
  .sort((a, b) => sortOrder === "asc" ? a.price - b.price : b.price - a.price); // ✅ Sorting



  return (
    <div className='container'>
      <h1 className='my-4'>Product Catalog</h1>

      <div className='row align-items-center mb-4'>
        <div className='col-md-3 col-sm-12 mb-2'>
          <CategoryFilter categories={categories} onSelect={handleCategorySelect}/>
        </div>

        <div className='col-md-5 col-sm-12 mb-12'>
          <input type='text' className='form-control' 
          placeholder='search for products'
          onChange={handleSearchChange}
           />
        </div>

        <div className='col-md-4 col-sm-12 mb-2'>
          <select className='form-control' onChange={handleSortChange}>
            <option value="asc"> Sort by Price: Low to High</option>
            <option value="desc"> Sort by Price: High to Low</option>
          </select>

        </div>


      </div>
      <div>
  {filteredProducts.length ? (
      <ProductList products={filteredProducts}/>
  ) : (
      <p>No products found</p>
  )}
</div>


    </div>
  )
}

export default App
