-- Inserting Data to Brand Table
INSERT INTO public.brands (
    id,
    created_at,
    updated_at,
    created_by,
    deleted_at,
    is_deleted,
    updated_by,
    description,
    is_active,
    logo_url,
    name,
    slug,
    sort_order,
    website_url
) VALUES
      (1, NOW(), NOW(), 1, NULL, false, 1, 'Global sportswear leader', true, 'https://via.placeholder.com/150?text=Nike', 'Nike', 'nike', 1, 'https://www.nike.com'),
      (2, NOW(), NOW(), 1, NULL, false, 1, 'German multinational corporation', true, 'https://via.placeholder.com/150?text=Adidas', 'Adidas', 'adidas', 2, 'https://www.adidas.com'),
      (3, NOW(), NOW(), 1, NULL, false, 1, 'German athletic footwear', true, 'https://via.placeholder.com/150?text=Puma', 'Puma', 'puma', 3, 'https://www.puma.com'),
      (4, NOW(), NOW(), 1, NULL, false, 1, 'American fitness brand', true, 'https://via.placeholder.com/150?text=Reebok', 'Reebok', 'reebok', 4, 'https://www.reebok.com'),
      (5, NOW(), NOW(), 1, NULL, false, 1, 'American sports equipment company', true, 'https://via.placeholder.com/150?text=UnderArmour', 'Under Armour', 'under-armour', 5, 'https://www.underarmour.com'),
      (6, NOW(), NOW(), 1, NULL, false, 1, 'American footwear corporation', true, 'https://via.placeholder.com/150?text=NewBalance', 'New Balance', 'new-balance', 6, 'https://www.newbalance.com'),
      (7, NOW(), NOW(), 1, NULL, false, 1, 'Japanese sports equipment', true, 'https://via.placeholder.com/150?text=Asics', 'Asics', 'asics', 7, 'https://www.asics.com'),
      (8, NOW(), NOW(), 1, NULL, false, 1, 'American lifestyle brand', true, 'https://via.placeholder.com/150?text=Converse', 'Converse', 'converse', 8, 'https://www.converse.com'),
      (9, NOW(), NOW(), 1, NULL, false, 1, 'American skateboarding shoes', true, 'https://via.placeholder.com/150?text=Vans', 'Vans', 'vans', 9, 'https://www.vans.com'),
      (10, NOW(), NOW(), 1, NULL, false, 1, 'Italian luxury fashion house', true, 'https://via.placeholder.com/150?text=Gucci', 'Gucci', 'gucci', 10, 'https://www.gucci.com');