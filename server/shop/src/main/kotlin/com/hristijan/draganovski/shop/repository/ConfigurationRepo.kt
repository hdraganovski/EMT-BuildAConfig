package com.hristijan.draganovski.shop.repository

import com.hristijan.draganovski.shop.dto.ConfigurationDto
import com.hristijan.draganovski.shop.entities.Configuration

interface ConfigurationRepo : EntityRepo<Configuration, ConfigurationDto>