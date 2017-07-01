    // single state store
    class Store {
        constructor (storage) {
            this.storage = storage; // assuming local storage will be passed in as storage
            // these are the key name you can use in Store
            this.CART_KEY = 'CART';
            this.QUEUE_KEY = 'QUEUE';
            this.FOODS_KEY = 'FOODS';
        }

        // you can get item by store.cartItems
        get cartItems () {
            return JSON.parse(this.storage.getItem(this.CART_KEY));
        }

        // to call setter, simply "assign" like store.cartItems = something
        set cartItems (cartItems) {
            this.storage.setItem(this.CART_KEY, JSON.stringify(cartItems));
        }

        get queue () {
            return JSON.parse(this.storage.getItem(this.QUEUE_KEY));
        }

        set queue (queue) {
            this.storage.setItem(this.QUEUE_KEY, JSON.stringify(queue));
        }

        get foods () {
            return JSON.parse(this.storage.getItem(this.FOODS_KEY));
        }

        set foods (foods) {
            this.storage.setItem(this.FOODS_KEY, JSON.stringify(foods));
        }
    }

    class Cart {
        // take dom element into JavaScript class to attachment events
        constructor(root, store) {
            this.root = root;
            this.store = store;
            this.items = this.store.cartItems;
            this.init();
        }

        init () {
            // Render a list of items under root element
            this.render();
            // TODO: attach remove cart items to rendered HTML
            
            // Remove buttons located in removeItem(item) function. Creation of click EventListener calling removeItem(item) is found in RemoveButton class.
        }

        destroy () {
            // TODO: remove all the events attached from init
            // Destroying of click EventListener is found in RemoveButton class.
        }

        // remove an item from shopping cart
        removeItem (item) {
         
            if (this.items != null) {
                var updated_list = [];
                var to_compare = item[0];
                for (var i = 0; i < this.items.length; i++) {
                    if (this.items[i][0] != to_compare) {
                        updated_list.push(this.items[i]);
                    }
                }
                this.store.cartItems = updated_list;
                this.items = updated_list;
            }
            this.render();
        }

        removeAllItems() {
            this.store.cartItems = [];
            this.items = [];
            this.render();
        }

        placeOrder () {
            // add item to statuses in store as status "in progress"
            console.log("Your order is ready!");
        }

        // render a list of item under root element
        render () {
            let tbody = this.root.querySelector('tbody');
            // using innerHTML to render a list of table row item under tbody
            tbody.innerHTML = ``;
            if (this.items === null) {
                this.items = [];
            } else if (this.items.length == 0) {
                tbody.innerHTML +=
                `<tr class="cart-table">
                <td>
                <h3>Add something on the cart</h3>
                
                </td>
                </tr>`; 
                return;
            }
            for (var i = 0; i < this.items.length; i++) {
                // for each item in cartItems, create a row with the item name and image in one cell, and then a box of quantity in the other cell.
                var item_name = this.items[i][0];
                
                var item_price = Number(this.items[i][1]);
                
                tbody.innerHTML +=
                `<tr class="cart-table">
                <td class="cart-table">
                <h3>${item_name}</h3>
                
                </td>
                <td class="cart-table">
                <h3>${item_name}</h3>
                </td>
                <td class="cart-table">
                <button class="remove_button" data-name=${item_name} data-index=${i}>Remove From cart!</button>
                </td>
                </tr>`;
            }

            
            
            let removeButtons = document.querySelectorAll('.remove_button');
            for (var i = 0; i < removeButtons.length; i++) {
                let btn = removeButtons[i];
                btn.addEventListener('click', () => {
                    let item = this.items[parseInt(btn.dataset.index)];
                    this.removeItem(item);
                });
            }
            

            
        }
    }    

    class RemoveButton {
        constructor(root, store, cart) {
            this.root = root;
            this.store = store;
            this.cart = cart;
            this.onClick = () => this.cart.removeItem(this.root.dataset.name);
            this.init();
        }

        init () {
            this.root.addEventListener("click", this.onClick);
        }

        destroy () {
            this.root.removeEventListener("click", this.onClick);
        }

    }

    class ClearStatusButton {
        constructor(root, store, cart) {
            this.root = root;
            this.store = store;
            this.cart = cart;
            this.onClick = () => this.clearStatuses();
            this.init();
        }

        init () {
            this.root.addEventListener("click", this.onClick);
        }

        destroy () {
            this.root.removeEventListener("click", this.onClick);
        }

        clearStatuses() {
            let status = document.querySelector(".status_table");  
        }
    }

    class CheckoutButton {
        constructor(root, store) {
            this.root = root;
            this.store = store;
            this.onClick = () => this.addItemToCart();
            this.init();
        }

        init () {
            this.root.addEventListener("click", this.onClick);
        }

        destroy () {
            this.root.removeEventListener("click", this.onClick);
        }

        addItemToCart () {
            // hint: you can use `dataset` to access data attributes
            // See passing data from HTML to JavaScript from course note
            let cartItems = this.store.cartItems || [];
            // TODO: replace with actual item
            var new_cart_item = true;
            for (var i = 0; i < cartItems.length; i++) {
                // go through each item name in cartItems. If they match, increase the quantity of existing item in cartItems by 1. Otherwise, add the item as a new entry in cartItems.
                var existing_cart_item_name = cartItems[i][0]
                if (this.root.dataset.name === existing_cart_item_name) {
                    var amount_to_add = Number(this.root.dataset.price);
                    cartItems[i][1] += amount_to_add;
                    new_cart_item = false;
                }
            }
            if (new_cart_item) {
                cartItems.push([this.root.dataset.name,  Number(this.root.dataset.price)]);
            }
            this.store.cartItems = cartItems;
        }
    }

    class StatusTable {
        // take dom element into JavaScript class to attachment events
        constructor(root, store) {
            this.root = root;
            this.store = store;
            init();
        }

        init () {
            // attach click event listener to table header row on each column
            render();
        }

        destroy () {
            // remove all the events attached from init
        }

        sort (columnName) {
            // after sorting the array of statuses, re render item to update view
            render();
        }

        // render rows of items under table using root.innerHTML
        render () {

        }
    }

    // DOMContentLoaded event will allow us to run the following function when
    // everything is ready. Think of the following code will only be executed by
    // the end of document
    document.addEventListener('DOMContentLoaded', () => {
        // use querySelector to find the table element (preferably by id selector)
        // let statusTable = document.querySelector('');
        // // use querySelector to find the cart element (preferably by id selector)
        let cart = document.querySelector('.cart-table');
        let checkoutButtons = document.querySelectorAll('.checkout-button');

        let store = new Store(window.localStorage);
        // if (table) {
        //     new StatusTable(table, store);
        // }
        if (cart) {
            new Cart(cart, store);
        }
        if (checkoutButtons && checkoutButtons.length) {
            for (var i = 0; i < checkoutButtons.length; i ++) {
                new CheckoutButton(checkoutButtons[i], store);
            }
        }
    });
    class Inventory {
        constructor(root, store) {
            this.root = root;
            this.store = store;
            this.init();
        }

        init () {
            this.render();
            // TODO: attach event listeners like click to remove items after rendering
        }

        destroy () {
       // TODO: remove event listeners added from the init above
           
            let removeInventoryButtons = document.querySelectorAll('.removebutton');
            for (var i = 0; i < removeInventoryButtons.length; i++) {
                let btn = removeInventoryButtons[i];
                btn.removeEventListener('click', () => {
                    let item = this.store.foods[parseInt(btn.dataset.index)];
                    this.removeItem(item);
                });
            }
        }

        removeItem (itemName) {
            // TODO: function to remove item given item name from store
            if (this.store.foods !== null) {
                var updated_list = [];
                var to_compare = itemName.name;
                for (var i = 0; i < this.store.foods.length; i++) {
                    if (this.store.foods[i].name !== to_compare) {
                        updated_list.push(this.store.foods[i]);
                    }
                }
                this.store.foods = updated_list;
            }
            this.render();
        }

       

        render () {
            // using innerHTML to render inventory listing
            let tbody = this.root.querySelector('tbody');
            // using innerHTML to render a list of table row item under tbody
            tbody.innerHTML = ``;

            // display message to add more liquor if there is no new recipes
            if (this.store.foods === null) {
                this.store.foods = [];
            } 
            // display all of the user-submitted brews
            for (var i = 0; i < this.store.foods.length; i++) {
                // for each item in local storage's FOODS, create a row with a cell for the item name and image, and one for description.
                var food_name = this.store.foods[i].name;
                var food_image = this.store.foods[i].image;
                var food_description = this.store.foods[i].description;

                tbody.innerHTML +=
                    `<tr >
                     <td>${food_name}</td>
                        <td>
                            <img src=${food_image}>
                        </td>
                        <td>${food_description}
                        </td>
                        <td>
                            <button class="removebutton" data-index=${i}>Remove item from Inventory</button>
                         </td>
                      </tr>`;
            }

            let removeInventoryButtons = document.querySelectorAll('.removebutton');
            for (var i = 0; i < removeInventoryButtons.length; i++) {
                let btn = removeInventoryButtons[i];
                btn.addEventListener('click', () => {
                    let item = this.store.foods[parseInt(btn.dataset.index)];
                    this.removeItem(item);
                });
            }
        }
    }


    class Menu {
        constructor(root, store) {
            this.root = root;
            this.store = store;
            this.init();
        }

        init () {
            this.render();
            // TODO: attach event listeners like click to remove items after rendering
        }

        render () {
            // using innerHTML to render inventory listing
            let tbody = this.root.querySelector('tbody');
            // using innerHTML to render a list of table row item under tbody
            tbody.innerHTML = ``;

            // display message to add more liquor if there is no new recipes
            if (this.store.foods === null) {
                this.store.foods = [];
            } 
            // display all of the user-submitted brews
            for (var i = 0; i < this.store.foods.length; i++) {
                // for each item in local storage's FOODS, create a row with a cell for the item name and image, and one for description.
                var food_name = this.store.foods[i].name;
                var food_image = this.store.foods[i].image;
                var food_description = this.store.foods[i].description;

                tbody.innerHTML +=
                    `<tr >
                     <td>${food_name}</td>
                        <td>
                            <img src=${food_image}>
                        </td>
                        <td>${food_description}
                        </td>
                        <td>
                            <button class="checkout-button" data-index=${i}>Add item to cart</button>
                         </td>
                      </tr>`;
            }


            let checkoutButtons = document.querySelectorAll('.checkout-button');
            if (checkoutButtons && checkoutButtons.length) {
                for (var i = 0; i < checkoutButtons.length; i++) {
                    new CheckoutButton(checkoutButtons[i], this.store, this.cart);
                }
            }
        }
    }


    class CreateFood {
        constructor(root, store) {
            this.root = root; // root should be the container of the form itself
            this.store = store;
            this.init();
        }

        init () {
        // attach click event to create button
            let createFoodButton = document.getElementById('addfood');
            if (createFoodButton) {
                createFoodButton.addEventListener("click", () => {
                    this.createFood();
                });
            }
            document.getElementById("").innerHTML = ``;
        }

        createFood () {
             let storeFoods = this.store.foods || [];
            var food_name = document.getElementById('food_name').value;
            var food_image = document.getElementById("food_image").value;
           
            var food_description = document.getElementById('food_description').value;
            var to_push = {name: food_name, image: food_image, description: food_description};

            

                // check to make sure submitted food is actually new
                var newfood = true;
                for (var i = 0; i < storeFoods.length; i++) {
                    if (to_push.name === storeFoods[i].name) {
                        newfood = false;
                        break;
                    }
                }
                if (newfood) {
                    storeFoods.push(to_push);
                    this.store.foods = storeFoods;
                    document.getElementById("").innerHTML = ``;
                    document.getElementById("").innerHTML = ``;
                } 
            
        }
    }
    document.addEventListener('DOMContentLoaded', () => {
        // use querySelector to find the table element (preferably by id selector)
        let statusTable = document.querySelector('.order_status_table');
        // // use querySelector to find the cart element (preferably by id selector)
        let cart = document.querySelector('.cart-table');
        let checkoutButtons = document.querySelectorAll('.addfood');

        // finding the form element to createFood
        let createFood = document.querySelector('#addfoodform');
        let inventory = document.querySelector('#inventory_table');
        let menu = document.querySelector('#menu_table');

        let store = new Store(window.localStorage);

        if (statusTable) {
            new StatusTable(statusTable, store);
        }
        if (cart) {
            var cartVar = new Cart(cart, store);
        }
        if (checkoutButtons && checkoutButtons.length) {
            for (var i = 0; i < checkoutButtons.length; i++) {
                new CheckoutButton(checkoutButtons[i], store, cartVar);
            }
        }

        if (createFood) {
            new CreateFood(createFood, store);
        }
        if (inventory) {
            new Inventory(inventory, store);
        }
        if (menu) {
        new Menu(menu, store, cartVar);
    }
    });